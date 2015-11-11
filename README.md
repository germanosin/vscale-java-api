# vscale.io java api

## Usage

```
VScaleIOAPI api = VScaleIOFactory.connect("YOUR_TOKEN")

synchronous

List<Scalet> scalets = api.scalets().get()

async

api.scalets().enqueue(new ResultCallback<List<Scalet>>() {
                                  @Override
                                  public void onResponse(List<Scalet> result) {

                                  }

                                  @Override
                                  public void onFailure(Throwable error) {

                                  }
                              });
```