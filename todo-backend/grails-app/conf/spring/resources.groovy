import de.psm.security.ExtendedAjaxAwareAuthenticationSuccessHandler
import de.psm.security.ExtendedExceptionTranslationFilter
import de.psm.security.ExtendedRequestHolderAuthenticationFilter
import org.codehaus.groovy.grails.plugins.springsecurity.AjaxAwareAuthenticationSuccessHandler
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

// Place your Spring DSL code here
beans = {
    exceptionTranslationFilter(ExtendedExceptionTranslationFilter) {
        authenticationEntryPoint = ref('authenticationEntryPoint')
        accessDeniedHandler = ref('accessDeniedHandler')
        authenticationTrustResolver = ref('authenticationTrustResolver')
        requestCache = ref('requestCache')
    }
    def conf = SpringSecurityUtils.securityConfig

    authenticationProcessingFilter(ExtendedRequestHolderAuthenticationFilter) {
        authenticationManager = ref('authenticationManager')
        sessionAuthenticationStrategy = ref('sessionAuthenticationStrategy')
        authenticationSuccessHandler = ref('authenticationSuccessHandler')
        authenticationFailureHandler = ref('authenticationFailureHandler')
        rememberMeServices = ref('rememberMeServices')
        authenticationDetailsSource = ref('authenticationDetailsSource')
        filterProcessesUrl = conf.apf.filterProcessesUrl // '/j_spring_security_check'
        usernameParameter = conf.apf.usernameParameter // j_username
        passwordParameter = conf.apf.passwordParameter // j_password
        continueChainBeforeSuccessfulAuthentication = conf.apf.continueChainBeforeSuccessfulAuthentication // false
        allowSessionCreation = conf.apf.allowSessionCreation // true
        postOnly = conf.apf.postOnly // true
    }

    authenticationSuccessHandler(ExtendedAjaxAwareAuthenticationSuccessHandler) {
        requestCache = ref('requestCache')
        defaultTargetUrl = conf.successHandler.defaultTargetUrl // '/'
        alwaysUseDefaultTargetUrl = conf.successHandler.alwaysUseDefault // false
        targetUrlParameter = conf.successHandler.targetUrlParameter // 'spring-security-redirect'
        ajaxSuccessUrl = conf.successHandler.ajaxSuccessUrl // '/login/ajaxSuccess'
        useReferer = conf.successHandler.useReferer // false
        redirectStrategy = ref('redirectStrategy')
    }
}
