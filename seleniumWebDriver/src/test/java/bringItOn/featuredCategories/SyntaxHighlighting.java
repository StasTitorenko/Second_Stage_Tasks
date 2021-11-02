package bringItOn.featuredCategories;

public enum SyntaxHighlighting {
    NONE{
        @Override
        public String toString() {
            return "None";
        }
    },
    BASH{
        @Override
        public String toString() {
            return "Bash";
        }
    },
    C{
        @Override
        public String toString() {
            return "C";
        }
    },
    C_SHARP{
        @Override
        public String toString() {
            return "C#";
        }
    },
    C_PLUS_PLUS{
        @Override
        public String toString() {
            return "C++";
        }
    },
    CSS{
        @Override
        public String toString() {
            return "CSS";
        }
    },
    HTML{
        @Override
        public String toString() {
            return "Html";
        }
    },
    JSON{
        @Override
        public String toString() {
            return "JSON";
        }
    },
    JAVA{
        @Override
        public String toString() {
            return "Java";
        }
    },
    JAVASCRIPT{
        @Override
        public String toString() {
            return "JavaScript";
        }
    },
    LUA{
        @Override
        public String toString() {
            return "Lua";
        }
    },
}
