import de.psm.security.ExtendedExceptionTranslationFilter
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.security.web.access.ExceptionTranslationFilter

// Place your Spring DSL code here
beans = {
    exceptionTranslationFilter(ExtendedExceptionTranslationFilter) {
        authenticationEntryPoint = ref('authenticationEntryPoint')
        accessDeniedHandler = ref('accessDeniedHandler')
        authenticationTrustResolver = ref('authenticationTrustResolver')
        requestCache = ref('requestCache')
    }
}
