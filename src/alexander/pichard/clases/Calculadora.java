package alexander.pichard.clases;

	
	import java.util.Scanner; // Importación de la clase Scanner.

	public class Calculadora{
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double res = 0;
	        String operacion;
	        boolean comprobar = false;
	 
	        do{
	            //Verificación de los datos puestos por el usuario del número 1.
	            /* Con matches, hay una condición de que dígitos primero puede
	            poner el usuario, en la condicional tenemos primero que solo se admite los caracteres '+' y '-', 
	            pero con la condición de que sea una sola vez o ninguna vez. 
	            Después tenemos que se admiten cualquier número del 0 al 9 y que se ponga o 0 veces o más veces,
	             es decir, se pone algo o no se pone nada. 
	             Mas otra condición de que solo admite el carácter '.' una o ninguna vez. Seguido del punto,
	              si es que se coloca, se admite cualquier número del 0 al 9 que sea una o más veces.*/
	            String numero1;
	            do {
	                System.out.println("\n Por favor, dime el primer número de la operación. ");
	                numero1 = sc.nextLine();
	            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
	            double nume1 = Double.parseDouble(numero1);
	            double n1 = new Double(numero1);
	            // Fin de la verificación de los datos puestos por el usuario del número 1.
	 
	            do {
	                System.out.println("\n ¿Que operación desea hacer? (Solo coloque un signo)");
	                System.out.println("Teniendo en cuenta que: \n + = sumar \n - = restar \n"
	                        + " x = multiplicar \n / = dividir \n * = elevar primer número al segundo numero."
	                        + "\n % = residuo");
	            operacion = sc.nextLine();
	                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x") ||
	                    operacion.equals("X") || operacion.equals("/") || operacion.equals("%") ||
	                    operacion.equals("*")) {
	                    comprobar = true;
	                }else { comprobar = false; }
	            } while (comprobar != true);
	 
	            // Verificación de los datos puestos por el usuario del número 2.
	            String numero2;
	            do {
	                System.out.println("\n Por favor, dime el segundo número.");
	                numero2 = sc.nextLine();
	            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
	            double nume2 = Double.parseDouble(numero2);
	            double n2 = new Double(numero2);
	            // Fin de la verificación de los datos puestos por el usuario del número 2.
	 
	            do{
	                comprobar = true;
	                switch(operacion){
	                    case "+":
	                        res = n1 + n2;
	                        break;
	                    case "-":
	                        res = n1 - n2;
	                        break;
	                    case "x":
	                    case "X":
	                        res = n1 * n2;
	                        break;
	                    case "/":
	                        /* Para evitar errores y añadir números complejos, si el usuario coloca 0 como segundo número, 
	                         * se piensa entonces que el denominador es 0, y por ello añado una condicional que lo verifique,
	                         *  y para hacer el codigo mas dinamico y no solo añadir un 1,
	                         *   le vuelvo a preguntar al usuario que añada un número distinto, podría volver a colocar 0,
	                         *    y es la razón por la que se encuentra en un ciclo, así que mientras n2 sea 0,
	                         *     el código seguirá ejecutando hasta que ponga otro.
	                         *      */
	                        while(n2 == 0){
	                                 do {
	                                    System.err.println(" En el denominador se encuentra \n"
	                                            + "un cero, para evitar errores coloca otro número.");
	                                    numero2 = sc.nextLine();
	                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
	                                    nume2 = Double.parseDouble(numero2);
	                                    n2 = new Double(numero2);
	                        }
	                        res = n1 / n2;
	                        break;
	                    case "*":
	                        res = Math.pow(n1, n2);
	                        break;
	                    case "%":
	                        while(n2 == 0){
	                                 do {
	                                    System.err.println(" En el denominador se encuentra \n"
	                                            + "un cero, para evitar errores coloca otro número.");
	                                    numero2 = sc.nextLine();
	                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
	                                    nume2 = Double.parseDouble(numero2);
	                                    n2 = new Double(numero2);
	                        }
	                        res = n1 % n2;
	                        break;
	                }
	            }while(comprobar != true);
	 
	            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
	            System.out.println("\n ¿Desea hacer alguna otra operación? \n");
	            System.out.println(" [s/n]");
	            do{
	                comprobar = true;
	                operacion = sc.nextLine();
	 
	                switch (operacion) {
	                    case "s":
	                    case "S":
	                    	break;
	                    case "n":
	                    	System.out.println("Gracias por utilizar nuestra app!!\n Vuelve pronto::");
	                    case "N":
	                    	System.out.println("Gracias por utilizar nuestra app!!\n Vuelve pronto::");
	                        break;
	                    default:
	                        System.err.println("\n Error, ponga un literal valido. \n");
	                        comprobar = false;
	                }
	            }while(comprobar != true);
	        }while(operacion.equals("s") || operacion.equals("S"));
	        sc.close();
	  }
	
}
