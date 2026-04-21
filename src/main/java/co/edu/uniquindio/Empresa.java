package co.edu.uniquindio;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado e) {
        listaEmpleados.add(e);
    }

    public void mostrarEmpleados() {
        listaEmpleados.stream()
                .forEach(e -> {
                    System.out.println(e);
                    System.out.println("-------------------");
                });
    }
    public Empleado buscarEmpleado(String documento) {
        if (documento == null)
            return null;

        return listaEmpleados.stream()
                .filter(e -> e.documento.equals(documento))
                .findFirst()
                .orElse(null);

    }
    public void mostrarResumenPagos() {
        listaEmpleados.stream()
                .forEach(e -> System.out.println(e.generarResumenPago()));
    }

    public float calcularNominaTotal() {
        float total = 0;
        for (Empleado e : listaEmpleados) {
            total += e.calcularSalarioNeto();
        }
        return total;
    }

    public List<Empleado> filtrarPorCategoria(CategoriaEmpleado categoria) {
        List<Empleado> resultado = new ArrayList<>();

        listaEmpleados.stream()
                .filter(e -> e.CategoriaEmpleado() == categoria)
                .forEach(resultado::add);

        return resultado;
    }

    public List<EmpleadoVentas> obtenerEmpleadosVentas() {
        List<EmpleadoVentas> resultado = new ArrayList<>();

        listaEmpleados.stream()
                .filter(e -> e instanceof EmpleadoVentas)
                .forEach(e -> resultado.add((EmpleadoVentas) e));

        return resultado;
    }

    public Empleado obtenerMejorPagado() {
        if (listaEmpleados.isEmpty()) return null;

        Empleado mejor = listaEmpleados.get(0);

        for (Empleado e : listaEmpleados) {
            if (e.calcularSalarioNeto() > mejor.calcularSalarioNeto()) {
                mejor = e;
            }
        }

        return mejor;
    }

    public double promedioSalarios() {
        if (listaEmpleados.isEmpty()) return 0;

        float suma = 0;
        for (Empleado e : listaEmpleados) {
            suma += e.calcularSalarioNeto();
        }

        return suma / listaEmpleados.size();
    }
}
