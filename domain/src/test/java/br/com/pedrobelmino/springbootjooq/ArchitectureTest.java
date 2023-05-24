package br.com.pedrobelmino.springbootjooq;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureTest {

    JavaClasses jc = new ClassFileImporter()
            .importPackages("br.com.pedrobelmino.springbootjooq");
    @Test
    public void domainArchitectureRule() {
        ArchRule r1 = noClasses()
                .should().dependOnClassesThat()
                .resideInAPackage("..springframework..");

        r1.check(jc);
    }
}