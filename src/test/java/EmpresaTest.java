import co.edu.uniquindio.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    // 1. Salario bruto ventas
    @Test
    void testSalarioBrutoVentas() {
        EmpleadoVentas emp = new EmpleadoVentas(1000000, 2000000);
        assertEquals(1100000, emp.calcularSalarioBruto());
    }

    // 2. Temporal salario neto no es 0
    @Test
    void testTemporalNoCero() {
        EmpleadoTemporal emp = new EmpleadoTemporal("1", 10, 50000);
        assertNotEquals(0, emp.calcularSalarioNeto());
    }

    // 3. Empleados almacenados
    @Test
    void testEmpleadosAlmacenados() {
        Empresa empresa = new Empresa();

        Empleado e1 = new Empleado("mario", 1000000) {
            @Override
            public float calcularSalarioBruto() {
                return getSalarioBase();
            }

            @Override
            public float getSalarioBase() {
                return 1000000;
            }
        };

        Empleado e2 = new Empleado("2", 2000000) {
            @Override
            public float calcularSalarioBruto() {
                return getSalarioBase();
            }

            @Override
            public float getSalarioBase() {
                return 2000000;
            }
        };

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);

        assertTrue(empresa.getEmpleados().contains(e1));
        assertTrue(empresa.getEmpleados().contains(e2));
    }

    // 4. Bonificación junior
    @Test
    void testBonificacionJunior() {
        EmpleadoJunior emp = new EmpleadoJunior(1000000);
        assertTrue(emp.getBonificacion() > 0);
    }

    // 5. Salario neto no negativo
    @Test
    void testSalarioNoNegativo() {
        Empleado emp = new Empleado("1", 1000000) {
            @Override
            public float calcularSalarioBruto() {
                return getSalarioBase();
            }

            @Override
            public float getSalarioBase() {
                return 1000000;
            }
        };

        assertTrue(emp.calcularSalarioNeto() >= 0);
    }

    // 6. Buscar inexistente
    @Test
    void testBuscarNull() {
        Empresa empresa = new Empresa();
        assertNull(empresa.buscarPorDocumento("999"));
    }

    // 7. Salario base negativo
    @Test
    void testSalarioBaseNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Empleado("1", -1000000) {
                @Override
                public float calcularSalarioBruto() {
                    return 0;
                }

                @Override
                public float getSalarioBase() {
                    return -1000000;
                }
            };
        });
    }

    // 8. Empleados con salario mayor a X
    @Test
    void testMayorA() {
        Empresa empresa = new Empresa();

        empresa.agregarEmpleado(new Empleado("1", 1000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 1000000; }
        });

        empresa.agregarEmpleado(new Empleado("2", 3000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 3000000; }
        });

        empresa.agregarEmpleado(new Empleado("3", 5000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 5000000; }
        });

        assertEquals(2, empresa.empleadosConSalarioMayorA(1500000).size());
    }

    // 9. Buscar documento inexistente
    @Test
    void testBuscarDocumento() {
        Empresa empresa = new Empresa();
        assertNull(empresa.buscarPorDocumento("ABC"));
    }

    // 10. Evitar duplicados
    @Test
    void testDuplicados() {
        Empresa empresa = new Empresa();

        empresa.agregarEmpleado(new Empleado("1", 1000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 1000000; }
        });

        assertThrows(IllegalArgumentException.class, () -> {
            empresa.agregarEmpleado(new Empleado("1", 2000000) {
                @Override
                public float calcularSalarioBruto() { return getSalarioBase(); }
                @Override
                public float getSalarioBase() { return 2000000; }
            });
        });
    }

    // 11. Mayor salario
    @Test
    void testMayorSalario() {
        Empresa empresa = new Empresa();

        Empleado e1 = new Empleado("1", 1000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 1000000; }
        };

        Empleado e2 = new Empleado("2", 5000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 5000000; }
        };

        Empleado e3 = new Empleado("3", 3000000) {
            @Override
            public float calcularSalarioBruto() { return getSalarioBase(); }
            @Override
            public float getSalarioBase() { return 3000000; }
        };

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);

        assertEquals(e2, empresa.getEmpleadoConMayorSalario());
    }

    // 12. Temporales > 100 horas
    @Test
    void testHorasTemporales() {
        Empresa empresa = new Empresa();

        empresa.agregarEmpleado(new EmpleadoTemporal("1", 120, 50000));
        empresa.agregarEmpleado(new EmpleadoTemporal("2", 80, 50000));

        assertEquals(1, empresa.temporalesMasDe100Horas().size());
    }

    // 13. Planta salario neto > base
    @Test
    void testPlantaMayorBase() {
        EmpleadoPlanta emp = new EmpleadoPlanta("johan", 1029374);
        assertTrue(emp.calcularSalarioNeto() > emp.getSalarioBase());
    }

    // 14. Temporal salario válido > 0
    @Test
    void testTemporalMayorCero() {
        EmpleadoTemporal emp = new EmpleadoTemporal("1", 20, 50000);
        assertTrue(emp.calcularSalarioNeto() > 0);
    }
}