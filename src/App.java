import com.uade.hotel.factories.room.HabitacionComun;
import com.uade.hotel.states.estadohabitacion.ContextoHabitacion;
import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        HabitacionComun habitacionComun = new HabitacionComun.ConstructorComun(1, 2).setInternetEnabled(true)
                .construir();
        habitacionComun.getDetalles();

        System.out.println("");

        HabitacionStateOcupado habitacionOcupada = new HabitacionStateOcupado();
        habitacionComun.cambiarEstado(habitacionOcupada);
        habitacionComun.getDetalles();
    }
}
