package com.ihc.toddler.manager;

import com.ihc.toddler.entity.HelpItem;

import java.util.ArrayList;
import java.util.List;

public class HelpManager {

    private static HelpManager helpManager = new HelpManager();

    private List<HelpItem> items = new ArrayList<>();
    private int currentHelp = 0;


    private HelpManager() {
        items.add(new HelpItem("Oie! =D", "Bem-vindo ao Toddler! Aqui, você aprende brincando", "Como usar?"));
        items.add(new HelpItem("Como usar?", "Todo texto pode ser clicado para ser lido. Como esse aqui, clica para tentar! =)", "Entendi"));
        items.add(new HelpItem("Mas e os botões? =o", "É a mesma coisa, mas com um clique longo. Como esse aqui embaixo:", "Legal"));
        items.add(new HelpItem("Isso aí!", "O Toddler é simples assim, já pode começar a usar.", "Começar"));
    }

    public static HelpManager getInstance() {
        return helpManager;
    }

    public HelpItem getCurrentHelpItem() {
        return items.get(currentHelp);
    }

    public void next() {
        currentHelp +=1;
    }

    public boolean isLast() {
        return currentHelp == items.size()-1;
    }
}
