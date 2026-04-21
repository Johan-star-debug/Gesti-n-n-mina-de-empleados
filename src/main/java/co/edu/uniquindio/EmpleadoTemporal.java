package co.edu.uniquindio;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad,
                            float descuentoSalud, float descuentoPension, CategoriaEmpleado categoria,
                            int diasTrabajados, float valorDia) {

        super(nombre, documento, edad, 0, descuentoSalud, descuentoPension, categoria);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        float salario = diasTrabajados * valorDia;
        return salario + calcularBonificacionCategoria();
    }
}
