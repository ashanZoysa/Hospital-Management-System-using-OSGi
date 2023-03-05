package hospital_mgt_patient_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;




public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Hospital management Patient producer service started.============");
		PatientActivaterService patientSer = new PatientServiceImpl();
		serviceRegisterer = context.registerService(PatientActivaterService.class.getName(), patientSer, null); //registering the patientService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("==============Hospital management Patient producer service closed.=============");
		serviceRegisterer.unregister();
	}

}
