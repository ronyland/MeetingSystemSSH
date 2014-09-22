package com.mms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mms.criteria.DeviceCriteria;
import com.mms.domain.Device;
import com.mms.service.IDeviceService;
import com.mms.util.Pager;
import com.mms.util.Validater;

public class DeviceAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1813327082149291542L;

	@Autowired
	public IDeviceService deviceService;

	public void setDeviceService(IDeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public String addDevice() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			int count = 0;
			if (Validater.isInteger(request.getParameter("count"))) {
				count = Integer.valueOf(request.getParameter("count"));
			} else {
				throw new Exception();
			}

			Device device = new Device();
			device.setName(name);
			device.setCount(count);
			device.setLeisure(count);
			deviceService.save(device);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteDevice() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			Device device = deviceService.load(id);
			deviceService.delete(device);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchDevice() {
		try {
			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			}

			DeviceCriteria deviceCriteria = new DeviceCriteria();
			deviceCriteria.setName(name);

			Pager pager = pageChanged();

			List<Device> devices = deviceService.search(deviceCriteria, pager);

			request.setAttribute("name", name);

			if (name != null) {
				request.setAttribute("searching", true);
			} else {
				request.setAttribute("searching", false);
			}

			request.setAttribute("devices", devices);
			request.setAttribute("totalCount", devices.size());
			request.setAttribute("pager", pager);
			request.setAttribute("current", request.getServletPath());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String updateDevice() {
		try {
			int id = 0;
			if (Validater.isInteger(request.getParameter("id"))) {
				id = Integer.valueOf(request.getParameter("id"));
			} else {
				throw new Exception();
			}

			String name = null;
			if (!Validater.isEmptyOrNull(request.getParameter("name"))) {
				name = request.getParameter("name");
			} else {
				throw new Exception();
			}

			int count = 0;
			if (Validater.isInteger(request.getParameter("count"))) {
				count = Integer.valueOf(request.getParameter("count"));
			} else {
				throw new Exception();
			}

			int leisure = 0;
			if (Validater.isInteger(request.getParameter("leisure"))) {
				leisure = Integer.valueOf(request.getParameter("leisure"));
			} else {
				throw new Exception();
			}

			Device device = new Device();
			device.setId(id);
			device.setName(name);
			device.setCount(count);
			device.setLeisure(leisure);
			deviceService.update(device);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
