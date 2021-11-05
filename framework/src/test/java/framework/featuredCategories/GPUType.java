package framework.featuredCategories;

public enum GPUType {
    NVIDIA_TESLA_K80 {
        @Override
        public String toString() {
            return "NVIDIA Tesla K80";
        }
    },
    NVIDIA_TESLA_P100 {
        @Override
        public String toString() {
            return "NVIDIA Tesla P100";
        }
    },
    NVIDIA_TESLA_P4 {
        @Override
        public String toString() {
            return "NVIDIA Tesla P4";
        }
    },
    NVIDIA_TESLA_V100 {
        @Override
        public String toString() {
            return "NVIDIA Tesla V100";
        }
    },
    NVIDIA_TESLA_T4 {
        @Override
        public String toString() {
            return "NVIDIA Tesla T4";
        }
    }
}
