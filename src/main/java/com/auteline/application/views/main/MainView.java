package com.auteline.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

   // private Text titleText;

   // private com.vaadin.flow.component.html.Image companyIcon;

    private TextField pinField;
    private TextField passcodeField;

    private Button loginButton;

    public MainView() {
        //titleText = new Text("M.T Wallet\n#1 In Trusted Banking");

        //companyIcon = new Image();

        pinField = new TextField("Account #");
        passcodeField = new TextField("User Pin #");
        loginButton = new Button("Login In");


        loginButton.addClickListener(e -> {
            Notification.show("Hello Account #" + pinField.getValue());
        });
        loginButton.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.CENTER, pinField, passcodeField, loginButton);

        setSizeFull();

        add(pinField, passcodeField, loginButton);
    }

}
