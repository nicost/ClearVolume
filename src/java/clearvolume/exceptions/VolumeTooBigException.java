package clearvolume.exceptions;

public class VolumeTooBigException extends ClearVolumeException
{

  private static final long serialVersionUID = 1L;

  public VolumeTooBigException(String message, Throwable pCause)
  {
    super(message, pCause);
  }

  public VolumeTooBigException(String pString)
  {
    super(pString, null);
  }

}