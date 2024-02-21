package org.abg.visitor.entities;

import org.abg.visitor.dto.Visitor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class VisitorsItemProcessor implements ItemProcessor<Visitor, Visitor> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");

    @Override
    public Visitor process(Visitor item) throws Exception {
        item.setVisitDate(dateFormat.parse(item.getStrVisitDate()));
        return item;
    }

}
