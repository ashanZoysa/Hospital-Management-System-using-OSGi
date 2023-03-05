package hospital_mgt_room_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("Hosptial Management Room producer service started.");
		RoomActivaterService roomSer = new RoomServiceImpl();
		serviceRegisterer = context.registerService(RoomActivaterService.class.getName(), roomSer, null); //registering the RoomService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("Hosptial Management Room producer service closed.");
		serviceRegisterer.unregister();
	}

}
