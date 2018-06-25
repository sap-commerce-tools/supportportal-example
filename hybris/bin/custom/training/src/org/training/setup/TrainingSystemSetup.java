/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package org.training.setup;

import static org.training.constants.TrainingConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.TrainingConstants;
import org.training.service.TrainingService;


@SystemSetup(extension = TrainingConstants.EXTENSIONNAME)
public class TrainingSystemSetup
{
	private final TrainingService trainingService;

	public TrainingSystemSetup(final TrainingService trainingService)
	{
		this.trainingService = trainingService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trainingService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrainingSystemSetup.class.getResourceAsStream("/training/sap-hybris-platform.png");
	}
}
