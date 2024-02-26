package org.abg.visitor.config;

import org.abg.visitor.entities.Visitor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class VisitorItemProcessor implements ItemProcessor<Visitor, Visitor> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");

    @Override
    public Visitor process(Visitor item) throws Exception {
        item.setVisitDate(dateFormat.parse(item.getStrVisitDate()));
        return item;
    }

}
