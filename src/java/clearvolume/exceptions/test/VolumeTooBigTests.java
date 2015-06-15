package clearvolume.exceptions.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import clearcuda.CudaAvailability;
import clearvolume.exceptions.VolumeTooBigException;
import clearvolume.renderer.ClearVolumeRendererInterface;
import clearvolume.renderer.factory.ClearVolumeRendererFactory;
import clearvolume.renderer.opencl.OpenCLAvailability;
import coremem.offheap.OffHeapMemory;

public class VolumeTooBigTests
{

	@Test
	public void testTooBigBuffer()
	{
		if (!CudaAvailability.isClearCudaOperational() && !OpenCLAvailability.isOpenCLAvailable())
			return;

		try
		{
			final ClearVolumeRendererInterface lNewBestRenderer = ClearVolumeRendererFactory.newBestRenderer8Bit(	"Test",
																																																						128,
																																																						128,
																																																						false);

			assertNotNull(lNewBestRenderer);

			lNewBestRenderer.setVisible(true);

			final long lSize = 1025;
			final OffHeapMemory lOffHeapMemory = OffHeapMemory.allocateBytes(lSize * lSize
																																				* lSize);

			try
			{
				lNewBestRenderer.setVolumeDataBuffer(	0,
																							lOffHeapMemory,
																							lSize,
																							lSize,
																							lSize,
																							1,
																							1,
																							1);
				fail();
			}
			catch (final VolumeTooBigException e)
			{
				// e.printStackTrace();
				assertTrue(true);
			}

		}
		catch (final Throwable e)
		{
			System.err.println("!!! COULD NOT BUILD ANY RENDERER NEITHER WITH CUDA OR OPENCL !!!");
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testTooBigDimension()
	{
		if (!CudaAvailability.isClearCudaOperational() && !OpenCLAvailability.isOpenCLAvailable())
			return;

		try
		{
			final ClearVolumeRendererInterface lNewBestRenderer = ClearVolumeRendererFactory.newBestRenderer8Bit(	"Test",
																																																						128,
																																																						128,
																																																						false);

			assertNotNull(lNewBestRenderer);

			lNewBestRenderer.setVisible(true);

			final long lSizeX = 4;
			final long lSizeY = 4;
			final long lSizeZ = 4096 * 16;
			final OffHeapMemory lOffHeapMemory = OffHeapMemory.allocateBytes(lSizeX * lSizeY
																																				* lSizeZ);

			try
			{
				lNewBestRenderer.setVolumeDataBuffer(	0,
																							lOffHeapMemory,
																							lSizeX,
																							lSizeY,
																							lSizeZ,
																							1,
																							1,
																							1);
				fail();
			}
			catch (final VolumeTooBigException e)
			{
				e.printStackTrace();
				assertTrue(true);
			}

		}
		catch (final Throwable e)
		{
			System.err.println("!!! COULD NOT BUILD ANY RENDERER NEITHER WITH CUDA OR OPENCL !!!");
			e.printStackTrace();
			fail();
		}
	}

}
