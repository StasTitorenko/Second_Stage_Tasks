package hurtMePlenty.featuredCategories;

public enum NumberOfGPU {
    NULL {
        @Override
        public String toString() {
            return "0";
        }
    },
    ONE {
        @Override
        public String toString() {
            return "1";
        }
    },
    TWO {
        @Override
        public String toString() {
            return "2";
        }
    },
    FOUR {
        @Override
        public String toString() {
            return "4";
        }
    },
    EIGHT {
        @Override
        public String toString() {
            return "8";
        }
    },
}
