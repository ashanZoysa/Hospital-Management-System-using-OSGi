package hospital_mgt_investor_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Hospital Management Started ============");
		InvestorActivatorService investorSer = new InvestorServiceImpl();
		serviceRegisterer = context.registerService(InvestorActivatorService.class.getName(), investorSer, null); //registering the medicalService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("============Hospital Management Stop ============");
		serviceRegisterer.unregister();
	}

}