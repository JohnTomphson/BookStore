package com.example.bookstore.payload.enumLists;

import com.example.bookstore.models.enums.ApplicationUserRole;
import com.example.bookstore.models.enums.Category;
import com.example.bookstore.models.enums.Language;
import com.example.bookstore.models.enums.Sinf;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Collections {


    /**
     * Method that gets all
     *
     * Purpose: For DataLoader and some on
     * @return List
     */
    @Bean
    public List<Category> categoryListList() {
        List<Category> categoryList = new ArrayList<Category>(
                Arrays.asList(Category.BIOLOGIYA,Category.FIZIKA,Category.GEOGRAFIYA,
                        Category.MATEM,Category.INFORMATIKA,Category.TARBIYA,Category.ONATILI,
                        Category.RASSOMCHILIK,Category.RUSTIL));
        return categoryList;
    }



    /**
     * Method that gets all
     *
     * Purpose: For DataLoader and some on
     * @return List
     */
    @Bean
    public List<Language> languageList() {
        List<Language> languageList = new ArrayList<Language>
                (Arrays.asList(Language.ENG,Language.QZ, Language.RUS,Language.UZ));
        return languageList;
    }

    @Bean
    public List<Sinf> sinfList() {
        List<Sinf> sinfs = new ArrayList<Sinf>
                (
                        Arrays.asList(Sinf.BIRINCHI_SINF, Sinf.IKKINCHI_SINF,Sinf.UCHINCI_SINF,
                        Sinf.TORTINCHI_SINF,Sinf.BESHINCHI_SINF,Sinf.OLTINCHI_SINF,Sinf.YETTINCHI_SINF,
                        Sinf.SAKKIZINCHI_SINF,Sinf.TUQQIZINCHI_SINF,Sinf.UNINCHI_SINF,Sinf.UNBIRINCHI_SINF));
        return sinfs;
    }



    /**
     * Method that gets all
     *
     * Purpose: For DataLoader and some on
     * @return Set();
     */
    @Bean
    public Set<ApplicationUserRole> applicationUserRoles() {
        Set<ApplicationUserRole> roleList = new HashSet<ApplicationUserRole>(
                Arrays.asList(
                        ApplicationUserRole.SUPER_ADMIN,ApplicationUserRole.ADMIN));
        return roleList;
    }
}
