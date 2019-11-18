package com.example.suitmedia.callback;

import com.example.suitmedia.model.Guest;

import java.util.List;

public interface OnGetGuestCallback {

    void onSuccess(List<Guest> guest);

    void onError();
}
