package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

class Workshop {
    private Date workshopDate;
    private String workshopTopic;
    private String workshopAuthor;
    private int workshopAttendersQuantity;

    Workshop(Date workshopDate, String workshopTopic, String workshopAuthor, int workshopAttendersQuantity) {
        this.workshopDate = workshopDate;
        this.workshopTopic = workshopTopic;
        this.workshopAuthor = workshopAuthor;
        this.workshopAttendersQuantity = workshopAttendersQuantity;
    }

    void view() {
        System.out.println("Date: " + new SimpleDateFormat("dd/MM/yyyy").format(workshopDate) +
                ", topic: " + workshopTopic + ", author: " + workshopAuthor +
                ", attenders quantity: " + workshopAttendersQuantity);
    }

    String getWorkshopAuthor() {
        return workshopAuthor;
    }


    int getWorkshopAttendersQuantity() {
        return workshopAttendersQuantity;
    }
}
