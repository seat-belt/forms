<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
  <path d="M12 2C6.5 2 2 6.5 2 12c0 5.5 4.5 10 10 10s10-4.5 10-10c0-5.5-4.5-10-10-10zm1.5 15.3c-1.7-1.6-4.2-1.5-5.8.2-1.6 1.7-1.5 4.2.2 5.8 1.7 1.6 4.2 1.5 5.8-.2 1.6-1.7 1.5-4.2-.2-5.8zm4.4-5.6l-3.5-3.5c-.4-.4-1-.4-1.4 0l-3.5 3.5c-.4.4-.4 1 0 1.4.4.4 1 .4 1.4 0l.7-.7v4.9c0 .6.4 1 1 1s1-.4 1-1v-4.9l.7.7c.4.4 1 .4 1.4 0 .4-.4.4-1 0-1.4z"/>
</svg>

import React from 'react';
import Head from 'next/head';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme();

const MyPage = () => {
  return (
    <ThemeProvider theme={theme}>
      <Head>
        <link
          rel="icon"
          href="/spa-icon.svg"
          type="image/svg+xml"
        />
      </Head>
      {/* Rest of your page */}
    </ThemeProvider>
  );
};

export default MyPage;
