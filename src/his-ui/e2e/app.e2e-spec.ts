import { HisUiPage } from './app.po';

describe('his-ui App', () => {
  let page: HisUiPage;

  beforeEach(() => {
    page = new HisUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
