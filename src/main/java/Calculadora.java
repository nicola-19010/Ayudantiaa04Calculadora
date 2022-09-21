public class Calculadora {
    public static void main(String[] args) {
        double resultado = dividir(1,0);
        System.out.println("resultado = " + resultado);
        /*double resultado2 = porcentajeDeUnNumero(1,0);
        System.out.println("resultado2 = " + resultado2);
        */
        double resultadoPotencia = potenciaDeUnNumero(4,3/2);

        System.out.println("resultadoPotencia = " + resultadoPotencia);
        //System.out.println("raizDe(-1.3) = " + raizDe(-1.3));
    }

    private static double sumar(double numero1, double numero2){
        return numero1+numero2;
    }

    private static double restar(double numero1, double numero2){
        return numero1-numero2;
    }

    private static double multiplicar(double numero1, double numero2){
        return numero1*numero2;
    }

    private static double dividir(double numero1, double numero2){
        return (numero1 / numero2);
    }

    public static double mayorDe(double numero1, double numero2){
        if (numero1>numero2) {
            return numero1;
        }else {
            return numero2;
        }
    }

    private static double menorDe(double numero1, double numero2){
        if (numero1<numero2){
            return numero1;
        }else {
            return numero2;
        }
    }

    private static double potenciaDeUnNumero(double numero1, double numero2){
        return Math.pow(numero1, numero2);
    }

    private static double porcentajeDeUnNumero(double numero1, double numero2){
        double porcentaje = (numero1/numero2)*100;
        return porcentaje;
    }

    private static double[] resolverSistema2x2(double[] ecuacion1abc, double[] ecuacion2abc){
        double a = ecuacion1abc[0];
        double b = ecuacion1abc[1];
        double c = ecuacion1abc[2];
        double d = ecuacion2abc[0];
        double e = ecuacion2abc[1];
        double f = ecuacion2abc[2];

        double x = (c*e - b*f)/(a*e - b*d);
        double y = (a*f - c*d)/(a*e - b*d);

        double[] solucionXY = {x,y};
        return solucionXY;
    }

    private static double[] resolverEcuacionDeLaRecta(double[] valoreX1X2, double[] valoresY1Y2){

        double x1 = valoreX1X2[0];
        double y1 = valoreX1X2[1];
        double x2 = valoresY1Y2[0];
        double y2 = valoresY1Y2[1];

        double m = (y2-y1)/(x2-x1);
        double b = y1 - (m * x1);

        double[] solucionMB = {m,b};
        return solucionMB;
    }

    private static double raizDe(double numero1){
        return Math.sqrt(numero1);
    }


    public static void pedirDatosEcuacion(){
        System.out.println("La ecuación cuadrática está dada por la forma: ax^2 + bx + c = 0");
        System.out.print("Ingrese el valor de a: ");
        int a = validarIngresoDeDatos();
        System.out.print("Ingrese el valor de b: ");
        int b = validarIngresoDeDatos();
        System.out.print("Ingrese el valor de c: ");
        int c = validarIngresoDeDatos();

        calcularSoluciones(a, b, c);
    }

    private static double[] calcularSoluciones(int a, int b, int c){
        double discriminante = (Math.pow(b, 2) - (4 * a * c));
        if (discriminante >= 0) {
            double soluciones[];
            if(discriminante == 0){
                soluciones = new double[1];
                soluciones[0] = ((-b) - (4 * a * c)) / (2 * a);
            }else{
                soluciones = new double[2];
                soluciones[0] = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                soluciones[1] = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            }
            return soluciones;
        }else {
            return null;
        }
    }

    private static void mostrarSoluciones(int a, int b, int c){
        double[] resultados = calcularSoluciones(a, b, c);
        if (resultados == null) {
            System.out.println("No tiene solución.");
        } else {
            for (double resultado : resultados) {
                System.out.println("Solución:");
                System.out.println(resultado);
            }
        }
    }

    private static int validarIngresoDeDatos() {
        Scanner teclado = new Scanner(System.in);
        int entrada;
        do {
            try {
                entrada = teclado.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Error, ingrese un valor que no perjudique a la fórmula: ");
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }


}
