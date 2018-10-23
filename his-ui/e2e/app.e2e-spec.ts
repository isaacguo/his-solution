import { PethosUiPage } from './app.po';

describe('pethos-ui App', () => {
  let page: PethosUiPage;

  beforeEach(() => {
    page = new PethosUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
