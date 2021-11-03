package hurtMePlenty.featuredCategories;

public enum OperationSystem {
    FREE_DEBIAN_CENTOS_COREOS_UBUNTU_OR_BYOL {
        @Override
        public String toString() {
            return "free";
        }
    },
    PAID_UBUNTU_PRO {
        @Override
        public String toString() {
            return "ubuntu-pro";
        }
    },
    PAID_WINDOWS_SERVER_2012_R2_WINDOWS_SERVER_2016_WINDOWS_SERVER_2019_WINDOWS_SERVER_2004_20H2 {
        @Override
        public String toString() {
            return "win";
        }
    },
}
