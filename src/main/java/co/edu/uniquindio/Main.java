package co.edu.uniquindio;
import java.util.Scanner;

   public class Main {

            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                Empresa empresa = new Empresa("Mi Empresa");

                int opcion;
                do {
                    System.out.println("\n===== MENÚ =====");
                    System.out.println("1. Agregar empleado de planta");
                    System.out.println("2. Agregar empleado de ventas");
                    System.out.println("3. Agregar empleado temporal");
                    System.out.println("4. Mostrar todos los empleados");
                    System.out.println("5. Buscar empleado por documento");
                    System.out.println("6. Mostrar empleado con mayor salario neto");
                    System.out.println("7. Mostrar nómina total");
                    System.out.println("8. Mostrar resumen de pagos");
                    System.out.println("9. Salir");
                    System.out.print("Seleccione una opción: ");

                    opcion = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    switch (opcion) {

                        case 1 -> {
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Documento: ");
                            String doc = sc.nextLine();

                            System.out.print("Edad: ");
                            int edad = sc.nextInt();

                            System.out.print("Salario base: ");
                            float salario = sc.nextFloat();

                            System.out.print("Horas extra: ");
                            int horas = sc.nextInt();

                            System.out.print("Valor hora extra: ");
                            float valorHora = sc.nextFloat();

                            System.out.print("Auxilio transporte: ");
                            float aux = sc.nextFloat();
                            sc.nextLine();

                            Empleado e = new EmpleadoPlanta(
                                    nombre, doc, edad, salario,
                                    0.04f, 0.04f, CategoriaEmpleado.JUNIOR,
                                    "Operario", horas, valorHora, aux
                            );

                            empresa.agregarEmpleado(e);
                        }

                        case 2 -> {
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Documento: ");
                            String doc = sc.nextLine();

                            System.out.print("Edad: ");
                            int edad = sc.nextInt();

                            System.out.print("Salario base: ");
                            float salario = sc.nextFloat();

                            System.out.print("Total ventas: ");
                            float ventas = sc.nextFloat();

                            System.out.print("Porcentaje comisión (ej: 0.05): ");
                            float comision = sc.nextFloat();
                            sc.nextLine();

                            Empleado e = new EmpleadoVentas(
                                    nombre, doc, edad, (int) salario,
                                    0.04f, 0.04f, CategoriaEmpleado.SEMI_SENIOR,
                                    ventas, comision
                            );

                            empresa.agregarEmpleado(e);
                        }

                        case 3 -> {
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Documento: ");
                            String doc = sc.nextLine();

                            System.out.print("Edad: ");
                            int edad = sc.nextInt();

                            System.out.print("Días trabajados: ");
                            int dias = sc.nextInt();

                            System.out.print("Valor por día: ");
                            float valorDia = sc.nextFloat();
                            sc.nextLine();

                            Empleado e = new EmpleadoTemporal(
                                    nombre, doc, edad,
                                    0.04f, 0.04f, CategoriaEmpleado.JUNIOR,
                                    dias, valorDia
                            );

                            empresa.agregarEmpleado(e);
                        }

                        case 4 -> empresa.mostrarEmpleados();

                        case 5 -> {
                            System.out.print("Ingrese documento: ");
                            String doc = sc.nextLine();

                            Empleado encontrado = empresa.buscarEmpleado(doc);

                            if (encontrado != null) {
                                System.out.println(encontrado);
                            } else {
                                System.out.println("Empleado no encontrado");
                            }
                        }

                        case 6 -> {
                            Empleado mejor = empresa.obtenerMejorPagado();
                            System.out.println("Mejor pagado: " + mejor);
                        }

                        case 7 -> System.out.println("Nómina total: " + empresa.calcularNominaTotal());

                        case 8 -> empresa.mostrarResumenPagos();

                        case 9 -> System.out.println("Saliendo...");

                        default -> System.out.println("Opción inválida");
                    }
                } while (opcion != 9);

                sc.close();
            }
   }