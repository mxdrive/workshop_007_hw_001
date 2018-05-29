package com.company;

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

    Date getWorkshopDate() {
        return workshopDate;
    }


    String getWorkshopTopic() {
        return workshopTopic;
    }


    String getWorkshopAuthor() {
        return workshopAuthor;
    }


    int getWorkshopAttendersQuantity() {
        return workshopAttendersQuantity;
    }
}
