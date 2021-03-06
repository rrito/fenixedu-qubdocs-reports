package org.fenixedu.qubdocs.domain;

import org.fenixedu.bennu.core.domain.Bennu;
import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;

import pt.ist.fenixframework.Atomic;

public class InstitutionLogo extends InstitutionLogo_Base {

    public InstitutionLogo() {
        super();
        setBennu(Bennu.getInstance());
    }

    public InstitutionLogo(final String filename, final byte[] content) {
        this();
        init(filename, filename, content);
        setUploader(Authenticate.getUser());
    }

    @Override
    public void delete() {
        setUploader(null);
        setInstitutionReportConfigurationFromLogo(null);
        setInstitutionReportConfigurationFromLetterheadLogo(null);
        setBennu(null);
        super.delete();
    }

    @Atomic
    public static InstitutionLogo create(final String filename, final byte[] content) {
        return new InstitutionLogo(filename, content);
    }

    @Override
    public boolean isAccessible(final User arg0) {
        //TODO
        return true;
    }

}
