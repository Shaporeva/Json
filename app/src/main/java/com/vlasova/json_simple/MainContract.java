package com.vlasova.json_simple;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainContract {
    interface View {
        void showText(ArrayList<HashMap<String, String>> arrayList);
    }

    interface Presenter {
        void onButtonWasClicked();
        void onDestroy();
    }

    interface Repository {
        ArrayList<HashMap<String, String>> loadNews();
    }
}
