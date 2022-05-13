package com.example.bookstore.models.enums;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Sinf {
    BIRINCHI_SINF("1"),
    IKKINCHI_SINF("2"),
    UCHINCI_SINF("3"),
    TORTINCHI_SINF("4"),
    BESHINCHI_SINF("5"),
    OLTINCHI_SINF("6"),
    YETTINCHI_SINF("7"),
    SAKKIZINCHI_SINF("8"),
    TUQQIZINCHI_SINF("9"),
    UNINCHI_SINF("10"),
    UNBIRINCHI_SINF("11");
   private final String classs;

    Sinf(String classs) {
        this.classs = classs;
    }



    /**
     *
     * @return
     */
    @Bean
    public List<Sinf> sinfList() {
        List<Sinf> sinfs = new ArrayList<Sinf>
                (
                        Arrays.asList(Sinf.BIRINCHI_SINF, Sinf.IKKINCHI_SINF,Sinf.UCHINCI_SINF,
                                Sinf.TORTINCHI_SINF,Sinf.BESHINCHI_SINF,Sinf.OLTINCHI_SINF,Sinf.YETTINCHI_SINF,
                                Sinf.SAKKIZINCHI_SINF,Sinf.TUQQIZINCHI_SINF,Sinf.UNINCHI_SINF,Sinf.UNBIRINCHI_SINF));
        return sinfs;
    }

}
