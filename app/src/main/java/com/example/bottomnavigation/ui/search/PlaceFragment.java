package com.example.bottomnavigation.ui.search;

public class PlaceFragment {

        public PlaceFragment(String name, int icon) {
            this.name = name;
            this.icon = icon;
        }

        private String name;
        private int icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    }


