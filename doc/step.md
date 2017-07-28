1. Create Gradle based Java Web project in Intellij IDEA.
2. Generate WEB-INF/web.xml
3. Edit build.gradle file
4. Create webapp/default.jsp
5. Edit web.xml
    - welcome-file-list
    - encoding filter
    - spring dispatcher servlet
    - default servlet
    - spring context loader listener
    - spring context config location
6. Create resources/log4j.properties
7. Create resources/applicationContext.xml
8. Create resources/jdbc.properties
    - jdbc_driverClassName
    - jdbc_url
    - jdbc_username
    - jdbc_password
9. Edit applicationContext.xml
    - context:properties-placeholder
    - data source bean
    - sqlSession factory bean
    - sqlSession template bean
10. Create WEB-INF/web-servlet.xml
11. Edit web-servlet.xml
    - mvc:annotation-driven
    - context:component-scan
        - ssm.controller
        - ssm.dao.impl
        - ssm.service.impl
12. Create BaseController class
13. Create BaseModel class
14. Create commons/inc.jsp
15. Create webapp/assets directory
16. Create util.Constant interface
17. Create util.Pagination class
18. Create dao.GenericDao interface
19. Create dao.impl.GenericDaoImpl class
20. Create service.GenericService interface
21. Create service.impl.GenericServiceImpl class
22. Create resources/freemarker.xml
    - freemarker bean    
23. Create commons/page.jsp
24. import jquery.js into assets/js
25. Create freemarker templates
    - code
        - Dao.ftl
        - Dao.Impl.ftl
        - Service.ftl
        - Service.Impl.ftl
        - Controller.ftl
    - config
        - mapper.ftl
    - page
        - index.ftl
        - add.ftl
        - list.ftl
        - edit.ftl
26. Create ssm.util.ComponentGenerator class