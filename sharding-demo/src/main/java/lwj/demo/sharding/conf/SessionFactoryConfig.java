package lwj.demo.sharding.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 配置mapper扫描和事务管理
 * 
 * @author liuwei
 * @date 2017-11-01
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "lwj.demo.sharding.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class SessionFactoryConfig implements TransactionManagementConfigurer {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    private String typeAliasPackage = "lwj.demo.sharding.entity";

    /**
     * 设置mapper 映射路径 设置datasource数据源
     * 
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置mybatis configuration 扫描路径
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mybatis/mybatis-config.xml")[0]);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mybatis/mapper/*.xml"));
        // 设置datasource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置typeAlias 包扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
