package co.edu.uniquindio;
public class EmpleadoVentas extends Empleado {

    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, int salarioBase,
                          float descuentoSalud, float descuentoPension, CategoriaEmpleado categoria,
                          float totalVentas, float porcentajeComision) {

        super();
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        float comision = totalVentas * porcentajeComision;
        return salarioBase + comision + calcularBonificacionCategoria();
    }

    @Override
    public float getSalarioBase() {
        return 0;
    }
}
