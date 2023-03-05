package hospital_mgt_medicineinventory_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Hospital Management Started ============");
		MedicalActivatorService medicalSer = new MedicalServiceImpl();
		serviceRegisterer = context.registerService(MedicalActivatorService.class.getName(), medicalSer, null); //registering the medicalService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("============Hospital Management Stopped ============");
		serviceRegisterer.unregister();
	}

}
