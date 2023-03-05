package hospitalemployee_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import HospitalEmployee_ProducerService.HospitalEmployeeService;


public class Activator implements BundleActivator {

	ServiceRegistration<?> publishEmployeeService;

	

	public void start(BundleContext context) throws Exception {
        System.out.println("Start Employee Producer");
		
        HospitalEmployeeService HospitalEmployeeService = new HospitalEmployeeServiceImpl();
		publishEmployeeService = context.registerService(HospitalEmployeeService.class.getName(), HospitalEmployeeService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		publishEmployeeService.unregister();
		System.out.println("Stop Employee Producer");
	}

}
