package framework.featuredCategories;

public enum Tabs {
    COMPUTE_ENGINE {
        @Override
        public String toString() {
            return "Compute Engine";
        }
    },
    GKE_STANDARD {
        @Override
        public String toString() {
            return "GKE Standard";
        }
    },
    GKE_AUTOPILOT {
        @Override
        public String toString() {
            return "GKE Autopilot";
        }
    },
    CLOUD_RUN {
        @Override
        public String toString() {
            return "Cloud Run";
        }
    },
    ANTHOS {
        @Override
        public String toString() {
            return "Anthos";
        }
    },
    VMWARE_ENGINE {
        @Override
        public String toString() {
            return "VMWARE Engine";
        }
    },
    APP_ENGINE {
        @Override
        public String toString() {
            return "APP Engine";
        }
    }
}
