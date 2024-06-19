package com.uade.hotel.factories.room;

import com.uade.hotel.states.estadohabitacion.ContextoHabitacion;
import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;

public class HabitacionComun extends Habitacion {

    public HabitacionComun(ConstructorComun constructor) {
        this.idHabitacion = constructor.idHabitacion;
        this.cantidadPersonas = constructor.cantidadPersonas;
        this.minibar = constructor.minibar;
        this.tv = constructor.tv;
        this.internet = constructor.internet;
        this.estado = constructor.estado;
    }

    // La clase Builder
    public static class ConstructorComun {
        // Par�metros requeridos
        private Integer idHabitacion;
        private Integer cantidadPersonas;
        // Par�metros opcionales
        private boolean minibar;
        private boolean tv;
        private boolean internet;
        private ContextoHabitacion estado;

        // El constructor del constructor
        public ConstructorComun(Integer idHabitacion, Integer cantidadPersonas) {
            this.idHabitacion = idHabitacion;
            this.cantidadPersonas = cantidadPersonas;
            this.estado = new ContextoHabitacion();
            HabitacionStateDisponible habitacionDisponible = new HabitacionStateDisponible();
            this.estado.cambiarEstado(habitacionDisponible);
        }

        public ConstructorComun setMinibarEnabled(boolean isMinibarEnabled) {
            this.minibar = isMinibarEnabled;
            return this;
        }

        public ConstructorComun setTvEnabled(boolean isTvEnabled) {
            this.tv = isTvEnabled;
            return this;
        }

        public ConstructorComun setInternetEnabled(boolean isInternetEnabled) {
            this.internet = isInternetEnabled;
            return this;
        }

        public HabitacionComun construir() {
            return new HabitacionComun(this);
        }
    }
}
