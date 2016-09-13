package hu.schonherz.training.venue.persistence.entity.enums;


public enum EventType {
    SZABAD_IDOPONT {
        public String toString() {
            return "Szabad időpont";
        }
    },
    FOGLALT_IDOPONT {
        public String toString() {
            return "Foglalt időpont";
        }
    },
    ITAL_AKCIO {
        public String toString() {
            return "Ital akció";
        }
    }
}
