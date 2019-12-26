package org.tron.core.net.message;

import com.google.protobuf.InvalidProtocolBufferException;
import org.tron.protos.Protocol;

public class EpochMessage extends TronMessage {

  private Protocol.EpochMessage epochMessage;

  public EpochMessage(byte[] packed) throws InvalidProtocolBufferException {
    super(MessageTypes.EPOCH_MESSAGE.asByte(), packed);
    this.epochMessage = Protocol.EpochMessage.parseFrom(packed);
  }

  public byte[] getChainId() {
    return epochMessage.getChainId().toByteArray();
  }

  public long getCurrentEpoch() {
    return epochMessage.getCurrentEpoch();
  }

  @Override
  public Class<?> getAnswerMessage() {
    return null;
  }
}
