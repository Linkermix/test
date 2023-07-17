package com.example.test;

import com.example.test.service.CounterService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private CounterService counterService;

    public MainView(CounterService service) {

        this.counterService = service;

        TextField counterField = new TextField();
        counterField.setValue(counterService.getValue().getValue().toString());
        Button addButton = new Button("Add");

        addButton.addClickListener(click -> {
            final Long newValue = Long.valueOf(counterField.getValue())+1;
            counterField.setValue(String.valueOf(newValue));
            counterService.updateValue(newValue);
        });

        counterField.addKeyDownListener(Key.ENTER, e -> {
            final Long newValue = Long.valueOf(counterField.getValue());
            counterField.setValue(String.valueOf(newValue));
            counterService.updateValue(newValue);
        });

        add(
                new H1("Type integer or click \"ADD\" button"),
                new HorizontalLayout(
                        counterField,
                        addButton
                )
        );
    }
}
