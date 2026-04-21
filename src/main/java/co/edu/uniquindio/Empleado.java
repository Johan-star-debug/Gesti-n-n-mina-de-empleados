package co.edu.uniquindio;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String nombre;
    public String documento;
    protected int edad;
    protected float salarioBase;
    protected float descuentoSalud;
    protected float descuentoPension;
    protected static CategoriaEmpleado CategoriaEmpleado;
    protected List<ResumenPago> listaResumenPago = new ArrayList<>();

    public Empleado() {
    }

    public Empleado(String mario, int i) {
    }

    public Enum<CategoriaEmpleado> CategoriaEmpleado() {
        return CategoriaEmpleado;
    }

    public CategoriaEmpleado Empleado(String nombre, String documento, int edad, float salarioBase,
                                      float descuentoSalud, float descuentoPension, CategoriaEmpleado CategoriaEmpleado) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.CategoriaEmpleado = CategoriaEmpleado;
        CategoriaEmpleado getCategoriaEmpleado;
        {
            return CategoriaEmpleado;
        }
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        return switch (CategoriaEmpleado) {
            case JUNIOR -> salarioBase * 0.05f;
            case SEMI_SENIOR -> salarioBase * 0.10f;
            case SENIOR -> salarioBase * 0.15f;
        };
    }
    public float calcularDescuentos() {
        return calcularSalarioBruto() * (descuentoSalud + descuentoPension);

    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public ResumenPago generarResumenPago() {
        ResumenPago resumen = new ResumenPago(
                documento,
                nombre,
                this.getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );

        listaResumenPago.add(resumen);
        return resumen;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salarioNeto=" + calcularSalarioNeto() +
                '}';
    }

    public Object getDocumento() {
        return null;
    }

    public abstract float getSalarioBase();
}
