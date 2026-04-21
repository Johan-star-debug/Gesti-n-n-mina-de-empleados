package co.edu.uniquindio;
public class EmpleadoPlanta extends Empleado {

    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase,
                          float descuentoSalud, float descuentoPension, CategoriaEmpleado categoria,
                          String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {

        super();
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase + (horasExtra * valorHoraExtra) + auxilioTransporte + calcularBonificacionCategoria();
    }

    @Override
    public float getSalarioBase() {
        return 0;
    }
}