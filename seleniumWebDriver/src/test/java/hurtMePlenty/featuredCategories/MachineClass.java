package hurtMePlenty.featuredCategories;

public enum MachineClass {
    REGULAR {
        @Override
        public String toString() {
            return "regular";
        }
    },
    PREEMPTIBLE {
        @Override
        public String toString() {
            return "preemptible";
        }
    }
}
