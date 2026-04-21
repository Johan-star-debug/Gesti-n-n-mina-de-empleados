package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Empleado> empleados = new ArrayList<>();

    // Obtener empleados
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // Agregar empleado (evita duplicados)
    public void agregarEmpleado(Empleado e) {
        for (Empleado emp : empleados) {
            if (emp.getDocumento().equals(e.getDocumento())) {
                throw new IllegalArgumentException("Empleado duplicado");
            }
        }
        empleados.add(e);
    }

    // Buscar por documento
    public Empleado buscarPorDocumento(String doc) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equals(doc)) {
                return e;
            }
        }
        return null;
    }

    // Empleado con mayor salario
    public Empleado getEmpleadoConMayorSalario() {
        Empleado max = null;
        double mayor = -1;

        for (Empleado e : empleados) {
            double salario = e.calcularSalarioNeto();
            if (salario > mayor) {
                mayor = salario;
                max = e;
            }
        }
        return max;
    }
    public List<EmpleadoTemporal> temporalesMasDe100Horas() {
        List<EmpleadoTemporal> resultado = new ArrayList<>();

        for (Empleado e : empleados) {
            if (e instanceof EmpleadoTemporal t) {
                if (t.getHorasTrabajadas() > 100) {
                    resultado.add(t);
                }
            }
        }

        return resultado;
    }

    // Empleados con salario mayor a un valor
    public List<Empleado> empleadosConSalarioMayorA(double valor) {
        List<Empleado> resultado = new ArrayList<>();

        for (Empleado e : empleados) {
            if (e.calcularSalarioNeto() > valor) {
                resultado.add(e);
            }
        }

        return resultado;
    }

    // Mostrar empleados
    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    // Buscar empleado
    public Empleado buscarEmpleado(String doc) {
        return buscarPorDocumento(doc);
    }

    // Mejor pagado
    public Empleado obtenerMejorPagado() {
        return getEmpleadoConMayorSalario();
    }

    // Nómina total
    public double calcularNominaTotal() {
        double total = 0;

        for (Empleado e : empleados) {
            total += e.calcularSalarioNeto();
        }

        return total;
    }

    // Resumen pagos
    public void mostrarResumenPagos() {
        for (Empleado e : empleados) {
            System.out.println("Empleado: " + e.getDocumento()
                    + " | Salario: " + e.calcularSalarioNeto());
        }
    }
}