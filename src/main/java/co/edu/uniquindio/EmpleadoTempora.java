import co.edu.uniquindio.CategoriaEmpleado;
import co.edu.uniquindio.Empleado;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad,
                            float descuentoSalud, float descuentoPension, CategoriaEmpleado categoria,
                            int diasTrabajados, float valorDia) {

        super();
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    public EmpleadoTemporal(String nombre, String documento, int edad, int i, float descuentoSalud, float descuentoPension, CategoriaEmpleado categoria) {
        super();
    }

    @Override
    public float calcularSalarioBruto() {
        float salario = diasTrabajados * valorDia;
        return salario + calcularBonificacionCategoria();
    }

    public int getDiasTrabajados() {
        return 0;
    }
}

    public int getHorasTrabajadas() {
        return 0;
    }

public void main() {
}
