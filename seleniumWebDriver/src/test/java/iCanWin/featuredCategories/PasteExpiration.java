package iCanWin.featuredCategories;

public enum PasteExpiration {
    NEVER {
        @Override
        public String toString() {
            return "Never";
        }
    },
    BURN_AFTER_READ {
        @Override
        public String toString() {
            return "Burn after read";
        }
    },
    TEN_MINUTES {
        @Override
        public String toString() {
            return "10 Minutes";
        }
    },
    ONE_HOUR {
        @Override
        public String toString() {
            return "1 Hour";
        }
    },
    ONE_DAY {
        @Override
        public String toString() {
            return "1 Day";
        }
    },
    ONE_WEEK {
        @Override
        public String toString() {
            return "1 Week";
        }
    },
    TWO_WEEKS {
        @Override
        public String toString() {
            return "2 Weeks";
        }
    },
    ONE_MONTH {
        @Override
        public String toString() {
            return "1 Month";
        }
    },
    SIX_MONTHS {
        @Override
        public String toString() {
            return "6 Months";
        }
    },
    ONE_YEAR {
        @Override
        public String toString() {
            return "1 Year";
        }
    },
}
